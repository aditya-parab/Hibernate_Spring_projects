<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <!-- <!DOCTYPE html>
    <html>

    <head>
        <title>Exam Page</title>
    </head>

    <body>
        <h1>Exam page</h1>
        <c:set var="questionNumber" value="1" scope="page" />
        <c:forEach items="${examQuestions}" var="examQuestion">
            <h2>Question ${questionNumber}:</h2>
            <p>${examQuestion.question.descr}</p>
            <form action="/submitAnswer" method="post">
                <c:forEach items="${examQuestion.question.questionOptions}" var="option">
                    <label>
                        <input type="radio" name="chosenOption" value="${option.id}">
                        ${option.descr}
                    </label>
                    <br>
                </c:forEach>
                <input type="hidden" name="examQuestionId" value="${examQuestion.id}">
                <input type="submit" value="Next">
            </form>
            <c:set var="questionNumber" value="${questionNumber + 1}" scope="page" />
        </c:forEach>
    </body>

    </html> -->

    <!DOCTYPE html>
    <html>

    <head>
        <title>Question Page</title>
    </head>

    <body>
        <h1>Questions Page</h1>
        <h2>Question : ${currentQuestion.question.descr}</h2>
        <form action="/submitAnswer" method="post">
            <c:forEach items="${currentQuestion.question.questionOptions}" var="option">
                <label>
                    <input type="radio" name="chosenOption" value="${option.id}">
                    ${option.descr}
                </label>
                <br>
            </c:forEach>
            <input type="hidden" name="examQuestionId" value="${currentQuestion.id}">
            <input type="submit" value="Next">
        </form>
    </body>

    </html>