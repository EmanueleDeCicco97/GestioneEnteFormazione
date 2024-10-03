<%@page import="com.emanuele.gestioneEnte.model.Corsista"%>
<%@page import="com.emanuele.gestioneEnte.model.Partecipazione"%>
<%@page import="com.emanuele.gestioneEnte.model.Insegna"%>
<%@page import="com.emanuele.gestioneEnte.model.Docente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emanuele.gestioneEnte.model.Corso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Corso di formazione</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        
        nav {
            background-color: #333;
            color: #fff;
            padding: 10px;
        }
        
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
        }
        
        nav ul li {
            display: inline;
            position: relative;
        }
        
        nav ul li a {
            color: #fff;
            display: block;
            padding: 10px 15px;
            text-decoration: none;
        }
        
        nav ul li:hover {
            background-color: #555;
        }
        
        nav ul ul {
            display: none;
            position: absolute;
            top: 100%;
            left: 0;
            background-color: #333;
            padding: 0;
            min-width: 200px; 
        }
        
        nav ul li:hover > ul {
            display: inherit;
        }
        
        nav ul ul li {
            width: 100%;
            display: block;
        }
        
        .content {
           
            margin-top: 50px;
        }
        
        form {
            max-width: 400px;
            margin: 0 auto;
        }
        
        form label,
        form input {
            display: block;
            margin-bottom: 10px;
        }
        
        form input[type="submit"] {
            background-color: #333;
            border: none;
            color: #fff;
            padding: 10px 15px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <nav>
        <ul>
            <li><a href="/index">Home</a></li>
            <li>
                <a href="#">Inserimento</a>
                <ul>
                    <li><a href="/inserimentoCorsista">Corsista</a></li>
                    <li><a href="/inserimentoDocente">Docente</a></li>
                    <li><a href="/inserimentoCorso">Corso</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Assegnazione</a>
                <ul>
                    <li><a href="/inserimentoPartecipazione">Ass.Corsista</a></li>
                    <li><a href="/inserimentoInsegna">Ass.Docente</a></li>
                   
                </ul>
            </li>
            <li>
                <a href="#">Ricerca</a>
                <ul>
                    <li><a href="/ricercaCorsista">Corsista</a></li>
                    <li><a href="/ricercaDocente">Docente</a></li>
                    <li><a href="/ricercaCorso">Corso</a></li>
                    <li><a href="/ricercaPartecipazione">Ass.Corsista</a></li>
                    <li><a href="/ricercaInsegna">Ass.Docente</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Modifica</a>
                <ul>
                    <li><a href="/modificaCorsista">Corsista</a></li>
                    <li><a href="/modificaDocente">Docente</a></li>
                    <li><a href="/modificaCorso">Corso</a></li>
                    <li><a href="/modificaPartecipazione">Ass.Corsista</a></li>
                    <li><a href="/modificaInsegna">Ass.Docente</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Cancellazione</a>
                <ul>
                    <li><a href="/cancellaCorsista">Corsista</a></li>
                    <li><a href="/cancellaDocente">Docente</a></li>
                    <li><a href="/cancellaCorso">Corso</a></li>
                    <li><a href="/cancellaPartecipazione">Ass.Corsista</a></li>
                    <li><a href="/cancellaInsegna">Ass.Docente</a></li>
                </ul>
            </li>

			<li>
				<a href="#">Stampa</a>
				<ul>
					<li><a href="/stampaCorsisti">Corsista</a></li>
					<li><a href="/stampaDocenti">Docente</a></li>
					<li><a href="/stampaCorsi">Corso</a></li>
					<li><a href="/stampaPartecipazioni">Ass.Corsista</a></li>
					<li><a href="/stampaInsegnamenti">Ass.Docente</a></li>
				</ul>
			</li>
        </ul>
    </nav>
    
    <div class="content">

    <h1>Stampa Docenti</h1>

	<table>
		<tr>
			<th style="padding-right: 10px;">Codice Fiscale</th>
			<th style="padding-right: 10px;">Nome</th>
			<th style="padding-right: 10px;">Cognome</th>
		</tr>
		<%
			List<Docente> docenti = (List<Docente>) request.getAttribute("docenti");
			for (Docente docente : docenti) {
		%>
		<tr>
			<td style="padding-right: 10px;"><%= docente.getCf_docente() %></td>
			<td style="padding-right: 10px;"><%= docente.getNome_docente() %></td>
			<td style="padding-right: 10px;"><%= docente.getCognome_docente() %></td>
		</tr>
		<%
			}
		%>
	</table>
    </div>
</body>
</html>








