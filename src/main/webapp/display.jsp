<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="model.book" %>
<%@ page import="helper.FactoryProvider" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>BOOKS</h1>
    
    <table>
        <tr>
            <th>Book Id</th>
            <th>Book Name</th>
            <th>Book's Author Name</th>
            <th>Book's Publisher Name</th>
            <th>Book Price</th>
        </tr>
        
        <% 
   
            Session session2 = FactoryProvider.getFactory().openSession();
            
            try {
                session2.beginTransaction();
                List<book> booklList = session2.createQuery("from book").getResultList();
                
                for (book bk : booklList) {
        %>
                <tr>
                    <td><%= bk.getBook_id() %></td>
                    <td><%= bk.getBook_name() %></td>
                    <td><%= bk.getBook_author() %></td>
                    <td><%= bk.getBook_publisher() %></td>
                    <td><%= bk.getBook_price() %></td>
                </tr>
        <%
                }
                session2.getTransaction().commit();
            } finally {
            	session2.close();
            }
        %>
        <div class="container text-center mt-2">
        	<a href="index.jsp" class="btn btn-primary">Home</a>
        </div>
    </table>
</body>
</html>
