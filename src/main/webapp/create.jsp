<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Information</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .container {
            width: 400px;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
            transition: transform 0.3s ease-in-out;
        }

        .container:hover {
            transform: scale(1.02);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 8px;
            color: #555;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #ddd;
            border-radius: 5px;
            transition: border-color 0.3s ease-in-out;
        }

        input:focus {
            outline: none;
            border-color: #4caf50;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Book Information</h2>
        <form action="create">
            <label for="bookName">Book Name:</label>
            <input type="text" id="book_name" name="book_name" required>

            <label for="bookId">Book ID:</label>
            <input type="text" id="book_id" name="book_id" required>

            <label for="bookAuthor">Book Author:</label>
            <input type="text" id="book_author" name="book_author" required>

            <label for="bookPrice">Book Price:</label>
            <input type="text" id="book_price" name="book_price" required>

            <label for="bookPublisher">Book Publisher:</label>
            <input type="text" id="book_publisher" name="book_publisher" required>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
