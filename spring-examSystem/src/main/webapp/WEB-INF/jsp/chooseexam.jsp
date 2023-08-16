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

        <h1>Welcome ${student.name}</h1>

        <h3>Now.. Time to choose your exam by Id.</h3>

        <p>
            Exam:
        <form method="POST" action="/chooseexam">
            <select name="examChosenTitle">
                <c:forEach items="${examList}" var="exam">
                    <option>${exam.title}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Submit">
        </form>

        </p>





    </body>

    </html>