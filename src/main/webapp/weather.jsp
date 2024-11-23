<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>профиль</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script>
        $(document).on("click", "#ajax-button", function () {
                $.get("/weather?city=" + $('#city').val(), function (response) {
                    $("#ajax-response").text(response)
                })
            }
        )
    </script>
</head>
<body>

<div id="ajax-response">

</div>

<form>
    <label for="city">Введите название города</label>
    <input type="text" name="city" id="city" required>
    <button id="ajax-button" type="button">получить погоду</button>
</form>


</body>
</html>