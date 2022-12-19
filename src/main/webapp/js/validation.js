const xError = document.getElementById("x_error");
const yError = document.getElementById("y_error");
const rError = document.getElementById("r_error");
const submitButton = document.getElementById("form-submit");
const form = document.forms[0];

function validate() {
    const data = new FormData(form);
    xError.innerHTML = "";
    yError.innerHTML = "";
    rError.innerHTML = "";

    // Validate X
    const parsedX = parseFloat(data.get("x"));
    if (isNaN(parsedX)) {
        xError.innerHTML = "Please select a value for X";
    }

    // Validate Y
    const parsedY = parseFloat(data.get("y"));
    if (isNaN(parsedY) || parsedY < -3 || parsedY > 5) {
        yError.innerHTML = "Y should be a float in the range of [-3; 5]";
    }

    // Validate R
    const rs = data.getAll("r");
    if (rs.length === 0) {
        rError.innerHTML = "Please select at least one value for R";
    }

    submitButton.disabled = xError.innerHTML !== '' || yError.innerHTML !== '' || rError.innerHTML !== '';
}

form.addEventListener("change", validate);
document.getElementById("Y_value").addEventListener("input", validate);
validate();

document.getElementById("graph").addEventListener("click", (e) => {
    const rs = new FormData(form).getAll("r");
    if (rs.length > 0) {
        const r = Math.max(...rs.map(parseFloat));
        let x = (e.offsetX / (300 / 2) - 1) * r * 1.5;
        x = Math.round(x * 100) / 100;
        let y = (e.offsetY / (300 / 2) - 1) * r * -1.5;
        y = Math.round(y * 100) / 100;

        document.getElementById("X_value").value = x;
        document.getElementById("X_value").checked = true;
        document.getElementById("Y_value").value = y;
        form.submit();
    } else {
        rError.innerHTML = "Please select at least one value for R";
        //alert("You need to select at least one value for R first");
    }
});