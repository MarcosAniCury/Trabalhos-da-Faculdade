public class exercicio5
{
	/*public static String[] tamarray (int i, String palavra,String[] frases)
	{
		String[] aranjo = new String[i];
		for (int j = 0;j < frases.length;j++)
		{
			aranjo[j] = frases[j];
		}
		if(aranjo [i - 1] != palavra)
			aranjo[i] = palavra;
		return aranjo;
	}*/
	public static boolean divisa(char letra,char divisor)
	{
		boolean divi = false;
		if(letra == divisor)
			divi = true;
		return divi;
	}
	public static String[] repartir(String frase, char divisor)
	{
		boolean verificacao;
		int ifrases = 1;
		String palavra;
		String[] frases = tamarray(ifrases,palavra,frases);
		for(int i = 0;i < frase.lenght();i++)
		{
			verificacao = divisa(frase.charAt(i),divisor);
			if(verificacao == false)
				palavra = palavra + frase.charAt(i);
			else
				ifrases++;
				frases = tamarray(ifrases,palavra,frases);		
		}
		return frases;
	}
	public static void main (String [] args)
	{
		String frase = MyIO.readLine();
		String[] para = repartir(frase," ");
		MyIO.print(para[0]);
	}
}
