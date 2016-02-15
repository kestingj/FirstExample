<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sample Module Input</title>
</head>

<body>
<g:form params="[modID: modID]">
    <label>Which of the following rhymes with ${word}?</label>
    <g:radioGroup name="candidates"
                  labels="${rc}"
                  values="${rc}">
        <p>${it.radio} ${it.label} </p>
    </g:radioGroup>

    <g:actionSubmit value="submit" />
</g:form>
</body>
</html>