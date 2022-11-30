const table = document.getElementById("results-table-body");

function fillTable() {
    fetch("attempts")
        .then(resp => {
            if (resp.ok) return resp.json()
            else throw resp.body
        })
        .then(json => {
            console.log(json);
            json.forEach((v, i, l) => {
                const row = document.createElement("tr");
                row.innerHTML = `    <td>
    ${v.x}
</td>
<td>
    ${v.y}
</td>
<td>
    ${v.r}
</td>
<td>
    ${v.result ? "HIT" : "MISS"}
</td>
<td>
    ${new Date(v.attemptTime).toLocaleString()}
</td>
<td>
    ${v.processTime} ms
</td>`
                table.appendChild(row);
            });
        })
        .catch(alert);
}

fillTable();