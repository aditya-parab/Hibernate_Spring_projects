<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>::Home</title>
        <style>
            .success {
                color: green;
            }

            .error {
                color: red;
            }
        </style>
    </head>

    <body>


        <h2> Student Login here ! </h2>

        <form method="POST" action="/studentdetails">
            <p>
                <input type="text" name="name" placeholder="Student's name">
            </p>
            <p>
                <input type="submit" value="Login">
            </p>
        </form>

    </body>

    </html>