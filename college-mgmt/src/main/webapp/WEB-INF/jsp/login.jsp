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
    <c:if test="${not empty registerSuccess}">
      <div class="success">
        User has registered successfully. Please login.
      </div>
    </c:if>

    <c:if test="${not empty invalidCreds}">
      <div class="error">
        Invalid username or password
      </div>
    </c:if>

    <h2> Login here ! </h2>
    <h3> ${greeting} </h3>
    <form method="POST" action="/login">
      <p>
        <input type="text" name="username" placeholder="Username">
      </p>

      <p>
        <input type="password" name="password" placeholder="Password">
      </p>

      <p>
        <input type="submit" value="Login">
        <a href="/registration">Register here!</a>
      </p>
    </form>

  </body>

  </html>