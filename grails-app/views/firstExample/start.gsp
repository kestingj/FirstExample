<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sample Module Input</title>
</head>

<body>
<ul>
    <g:each in="${lsOut}" var="it">
        <li>${it}</li>
    </g:each>
</ul>

<g:form params="[words: lsOut, modID: modID]">
    <g:actionSubmit value="submit" />
</g:form>
</body>
</html>