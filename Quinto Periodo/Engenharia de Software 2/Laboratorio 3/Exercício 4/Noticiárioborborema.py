from abc import ABC, abstractmethod
from tkinter import *
import tkinter


class noticiario(ABC):

    @abstractmethod
    def notificanoticia(self, textonoticia, dia, mes, topico):
        pass


class consomenoticia:
    def notificacaonoticia(self, textonoticia, dia, mes, topico):
        pass


class consumidor(consomenoticia):
    def _int_(self):
        self.__textonoticia
        self.__dia
        self.__mes
        self.__topico

    @staticmethod
    def notificacaonoticia(textonoticia, dia, mes, topico):
        textonoticia(textonoticia)
        dia(dia)
        mes(mes)
        topico(topico)

    @property
    def textonoticia(self):
        return self.__textonoticia

    @property
    def dia(self):
        return self.__dia

    @property
    def mes(self):
        return self.__mes

    @property
    def topico(self):
        return self.__topico

    @textonoticia.setter
    def textonoticia(self, textonoticia):
        self.__textonoticia = textonoticia

    @dia.setter
    def dia(self, dia):
        self.__dia = dia

    @mes.setter
    def mes(self, mes):
        self.__mes = mes

    @topico.setter
    def topico(self, topico):
        self.__topico = topico

    def notificar(self):
        app = Tk()

        app.title("NOTICIA")

        app.grid_columnconfigure(0, minsize=100)
        app.grid_columnconfigure(1, minsize=100)
        app.grid_columnconfigure(2, minsize=100)
        app.grid_columnconfigure(3, minsize=100)
        app.grid_columnconfigure(4, minsize=100)

        app.grid_rowconfigure(0, minsize=100)
        app.grid_rowconfigure(1, minsize=100)
        app.grid_rowconfigure(2, minsize=100)
        app.grid_rowconfigure(3, minsize=100)
        app.grid_rowconfigure(4, minsize=100)
        app.grid_rowconfigure(5, minsize=100)

        app.resizable(False, False)

        title = Label(app)
        title["text"] = "NOTICIA"
        title["font"] = "Rockwell", "20", "bold"
        title.grid(column=0, row=0, columnspan=5)

        lb_day = Label(app)
        lb_day["text"] = "Dia"
        lb_day["font"] = "Rockwell Condensed", "15"
        lb_day.grid(column=1, row=1)

        day = Listbox(app)
        day["font"] = "Rockwell", "10"
        day["width"] = 15
        day["height"] = 1
        day.grid(column=2, row=1)
        day.insert(END, values=self.__dia)

        lb_month = Label(app)
        lb_month["text"] = "Mes"
        lb_month["font"] = "Rockwell Condensed", "15"
        lb_month.grid(column=1, row=2)

        month = Listbox(app)
        month["font"] = "Rockwell", "10"
        month["width"] = 15
        month["height"] = 1
        month.grid(column=2, row=2)
        month.insert(END, values=self.__mes)

        lb_topic = Label(app)
        lb_topic["text"] = "Topico"
        lb_topic["font"] = "Rockwell Condensed", "15"
        lb_topic.grid(column=1, row=3)

        topic = Listbox(app)
        topic["font"] = "Rockwell", "10"
        topic["width"] = 15
        topic["height"] = 1
        topic.grid(column=2, row=3)
        topic.insert(END, values=self.__topico)

        lb_text = Label(app)
        lb_text["text"] = self.__textonoticia
        lb_text["font"] = "Rockwell Condensed", "15"
        lb_text.grid(column=1, row=4, columnspan=3)

        app.mainloop()

class noticiarioassina(noticiario, ABC):
    pass

noticia01 = {}
noticia01["dia"] = "11"
noticia01["mes"] = "02"
noticia01["topico"] = "eleicao"
noticia01["texto"] = "Sobe o número de votos brancos ou nulos na eleicao de 2022"

noticia02 = {}
noticia02["dia"] = "22"
noticia02["mes"] = "03"
noticia02["topico"] = "games"
noticia02["texto"] = "Impostos no mundo dos games caem mais 10% em 2022"

noticias = consumidor()
noticias = consumidor.notificacaonoticia(noticia01["texto"],noticia01["dia"], noticia01["mes"], noticia01["topico"])
noticias = consumidor.n