<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>::Register here::</title>
  </head>
  <body>
    <main>
        <h2>Register here! ${greeting}</h2>
        <form method = "POST", action="/register">
            <p>
                <input placeholder="Username"  name = "username">
            </p>
            <p>
                 <input placeholder="Password" type="password" name="password">
            </p>
            <select name="country" id="country">
                <c:forEach items = "${countries}" var="country">
                    <option>${country}</option>
                </c:forEach>
            </select>

            <p>Please select your gender</p>
            <input type="radio" id="male" name="gender" value="M">
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="F">
            <label for="female">Female</label>
            <p>
                  <input type="submit" value="Register">
            </p>
        </form>
    </main>
  </body>
</html>