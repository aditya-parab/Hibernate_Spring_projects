<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Exam Page</title>
    </head>

    <body>
        <h1>Exam page</h1>
        <c:forEach items="${examQuestions}" var="examQuestion">
            <h2>Question ${examQuestion.question.id}:</h2>
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
        </c:forEach>

    </body>

    </html>