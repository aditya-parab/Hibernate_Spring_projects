<%@ taglib uri="jakarta.tags.core" prefix="c" %>

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
            <h2>Register here! (${greeting})</h2>
            <form>
                <p>
                    <input placeholder="Username">
                </p>
                <p>
                    <input placeholder="Password">
                </p>

                <p>
                    Country:
                    <select>
                        <c:forEach items="${countries}" var="country">
                            <option>${country}</option>
                        </c:forEach>
                    </select>
                </p>


                <p>Please select your gender</p>
                <input type="radio" id="male" name="gender" value="male">
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="female">
                <label for="female">Female</label>
                <p>
                    <input type="submit" value="Register">
                    <a>Register</a>
                </p>
            </form>
        </main>
    </body>

    </html>