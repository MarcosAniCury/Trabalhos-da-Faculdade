import java.io.*;
import java.lang.reflect.*;

public class CRUD <T extends Registro>
{
    private static HashExtensivel<pcvLivro> index;
    RandomAccessFile arq;
    Constructor<T> construtor;
    String arq_name;

    //Abertura e fechamento

    public CRUD(Constructor<T> c, String nameArq) throws Exception 
    {
        this.arq_name = nameArq;
        arq = new RandomAccessFile(nameArq, "rw");
        index = new HashExtensivel<>(pcvLivro.class.getConstructor(), 4, "dados/pessoas.hash_d.db",
        "dados/pessoas.hash_c.db");
        this.construtor = c;
    }

    public boolean end() //fechar o crud
    {
        boolean conseguiu = false;
        try
        {
            arq.close();
            conseguiu = true;
        }
        catch (IOException erro)
        {
            erro.printStackTrace();
        }
        return conseguiu;
    }

    //CRUD

    public int create(T obj)
    {
        try
        {
            arq.seek(0);
            if (arq.read() == -1) //verificar se o arquivo está vazio
                arq.writeInt(-1); //atribuir -1 ao ultimo id
            arq.seek(0);
            int last_id = arq.readInt();
            if (last_id < -1)
                throw new IOException("Ultimo id nao encontrado");
            obj.setId(++last_id);
            arq.seek(0);
            arq.writeInt(obj.getId()); //sobre escreve o ultimo id utilizado
            arq.seek(arq.length());
            newRegister(obj);
        }
        catch (IOException erro)
        {
            erro.printStackTrace();
        }
        return obj.getId();
    }

    public T read(int id) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        T obj_return = construtor.newInstance();
        try
        {
            long pos = -1; //criação da var long
            pcvLivro temp = index.read(id); 
            if (temp != null) //Verifica se o objeto existe na tabela hash
                pos = temp.getPos(); 
            byte[] obj = null;
            if (pos > -1) //verifica se o arquivo não está vazio
            {
                arq.seek(pos);
                boolean not_lapide = notLapide();
                int tamRegistro = arq.readInt();
                if (not_lapide)
                {
                    obj = new byte[tamRegistro];
                    arq.read(obj);
                    obj_return.fromByteArray(obj);
                    if (obj_return.getId() == id)
                        return obj_return;
                    else
                        obj_return = construtor.newInstance();
                }
            }
            return obj_return;
        }
        catch(Exception erro)
        {
            erro.printStackTrace();
        }
        return obj_return;
    }

    public boolean update(T new_obj)
    {
        boolean success = false;
        try
        {
            byte[] obj = null;
            pcvLivro temp = index.read(new_obj.getId());
            long pos = temp.getPos();
            if (pos > -1) //verifica se o não arquivo está vazio
            {
                arq.seek(pos);
                boolean not_lapide = notLapide();
                int tamRegistro = arq.readInt();
                if (not_lapide)
                {
                    obj = new byte[tamRegistro];
                    arq.read(obj);
                    int tam_new_obj = new_obj.toByteArray().length;
                    arq.seek(pos);
                    if (tam_new_obj < tamRegistro) //verifica se o novo registro é menor que o antigo
                        updateRegister(new_obj, tamRegistro);
                    else
                    {
                        //mata o registro atual
                        arq.write('*');
                        pos = arq.length();
                        arq.seek(pos); //vai pro fim do arquivo pra criar um novo registro de tamanha maior que o anterior
                        updateRegister(new_obj);
                    }
                }
            }
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
        }
        return success;
    }

    public boolean delete(int id)
    {
        boolean success = false;
        try
        {
            pcvLivro temp = index.read(id);
            long pos = temp.getPos();
            if (pos > -1) //verifica se o arquivo não está vazio
            {
                arq.seek(pos);
                boolean not_lapide = notLapide();
                if (not_lapide)
                {
                    arq.seek(pos);
                    arq.write('*');
                    index.delete(id);
                    success = true;
                }
            }
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
        }
        return success;
    }

    //Funcoes essenciais

    public boolean newRegister(T obj)
    {
        boolean success = false;
        try
        {
            //criar na tabela hash um novo objeto
            long pos = arq.getFilePointer();
            pcvLivro objPcv = new pcvLivro(obj.getId(), pos); 
            index.create(objPcv);
            //escreve o registro no arquivo
            arq.write(' ');
            byte[] obj_byte = obj.toByteArray();
            arq.writeInt(obj_byte.length); //escreve tamanho do registro
            arq.write(obj_byte);
            success = true;
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
        }
        return success;
    }

    public boolean updateRegister(T obj)
    {
        boolean success = false;
        try
        {
            //escreve o registro no arquivo
            long pos = arq.getFilePointer();
            arq.write(' ');
            byte[] obj_byte = obj.toByteArray();
            arq.writeInt(obj_byte.length); //escreve tamanho do registro
            arq.write(obj_byte);
            //atualizar o objeto com o id da tabela hash
            pcvLivro objPcv = new pcvLivro(obj.getId(), pos);
            index.update(objPcv);
            success = true;
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
        }
        return success;
    }

    public boolean updateRegister(T obj, int tam)
    {
        boolean success = false;
        try
        {
            //escreve o registro no arquivo
            long pos = arq.getFilePointer();
            arq.write(' ');
            byte[] obj_byte = obj.toByteArray();
            arq.writeInt(tam); //escreve tamanho do registro
            arq.write(obj_byte);
            //atualizar o objeto com o id da tabela hash
            pcvLivro objPcv = new pcvLivro(obj.getId(), pos);
            index.update(objPcv);
            success = true;
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
        }
        return success;
    }

    public boolean notLapide() throws IOException
    {
        return (arq.readByte() != '*');
    }
}
