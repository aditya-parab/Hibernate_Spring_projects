<%@ taglib uri = "jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>::Home::</title>
    <link rel="stylesheet" href="style.css">
    </style>
  </head>
  <body>
    <nav>
        Welcome ${username}
        <a href="/logout" method="GET">Logout</a>
    </nav>
  </body>
</html>