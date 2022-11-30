<%@ page import="com.exmpale.models.PointResult" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PointResult[] results = (PointResult[]) request.getAttribute("results");
%>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
</head>
<body>
    <div style="display: grid; justify-items: center; align-content: flex-start;">
        <div>
            <table id="table">
                <thead>
                <tr>
                    <th style="width: 100px;">X coordinate</th>
                    <th style="width: 100px;">Y coordinate</th>
                    <th style="width: 100px;">Radius</th>
                    <th style="width: 100px;">Result</th>
                    <th style="width: 100px;">Attempt time</th>
                    <th style="width: 100px;">Execution time</th>
                </tr>
                </thead>
                <tbody id="results-table-body">
                    <%
                        for (int i = 0; i < results.length; i++) {
                    %>
                    <tr>
                        <td>
                            <%=results[i].x()%>
                        </td>
                        <td>
                            <%=results[i].y()%>
                        </td>
                        <td>
                            <%=results[i].r()%>
                        </td>
                        <td>
                            <%=(results[i].result() ? "HIT" : "MISS")%>
                        </td>
                        <td class="timestamp-to-convert"><%=results[i].attemptTime()%></td>
                        <td>
                            <%=results[i].processTime()%> ms
                        </td>
                    </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
        <a href="<%=request.getContextPath()%>">Home</a>
    </div>
    <script>
        const timestampsEls = document.getElementsByClassName("timestamp-to-convert");
        for (let i = 0; i < timestampsEls.length; i++) {
            const localeString = new Date(parseInt(timestampsEls.item(i).innerHTML)).toLocaleString();
            timestampsEls.item(i).innerHTML = localeString;
        }
    </script>
</body>
</html>
