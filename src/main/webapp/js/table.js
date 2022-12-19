const table = document.getElementById("results-table-body");

fetch("attempts")
    .then(resp => {
        if (resp.ok) return resp.json()
        else throw resp.body
    })
    .then(json => {
        fillTable(json);
        document.getElementById("forms").addEventListener("change", () => fillGraph(json));
    })
    .catch(alert);

function fillTable(points) {

    points.forEach((v, i, l) => {
        const row = document.createElement("tr");
        row.innerHTML = `<td>
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
</td>`;
        table.appendChild(row);
    });
}

function fillGraph(points) {
    const graph = document.getElementById("graph");
    const circleGroup = document.getElementById("dots");
    circleGroup.innerHTML = "";
    points.forEach((v, i, l) => {
        const rs = new FormData(document.getElementById("forms")).getAll("r");
        if (rs.length > 0) {
            const r = Math.max(...rs.map(parseFloat));
            const x = (v.x / (r * 3) + 0.5) * 300;
            const y = 300 - (v.y / (r * 3) + 0.5) * 300;
            console.log(x, y, v.x, v.y, r);
            const circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
            circle.setAttributeNS(null, "cx", x);
            circle.setAttributeNS(null, "cy", y);
            circle.setAttributeNS(null, "r", 1);
            circle.setAttributeNS(null, "stroke", "red");
            circle.setAttributeNS(null, "stroke-width", 3);
            circleGroup.appendChild(circle);
        }
    })
}