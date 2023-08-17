<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>::Login here::</title>
    <style>
        .success {
            color:green;
        }
        .fail {
            color:red;
        }
    </style>
  </head>
  <body>
    <main>
    <c:if test="${not empty invalidCreds}">
            <div class="fail">Invalid username or password </div>
    </c:if>
    <c:if test="${not empty registerSuccess}">
        <div class="success">Registered Successfully! </div>
    </c:if>
        <h2>Login here! ${greeting}</h2>
        <form action="/login", method="POST">
            <p>
                <input placeholder="Username" name="username">
            </p>
            <p>
                 <input placeholder="Password" type="password" name="password">
            </p>
            <p>
                  <input type="submit" value="Login">
                  <a href="/register">Register here!</a>
            </p>
        </form>
    </main>
  </body>
</html>