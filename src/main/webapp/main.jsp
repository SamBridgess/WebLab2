<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <title>WebLab2 Миняев Илья </title>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <script src="js/table.js" defer></script>
    <script src="js/validation.js" defer></script>
</head>

<body style="background-color: #360c36">
<!-- name and group -->
<header id="header" style="margin-bottom: 2%;">
    <span>Миняев Илья P32312 Вариант: 3231211</span>
</header>

<!-- Main data -->
<div class="main" style="display:flex; justify-content: center;">
    <!-- Form to send -->
    <div>
        <form id="forms" class="forms" method="POST" action="<%=request.getContextPath()%>">

            <div class="form">
                <div class="values">
                    <!-- X value block -->


                    <div class="X_value">
                        <label class="X_value"> X: </label><br>
                        <input value="-3" type="radio" id="x_-3" name="x"><label for="x_-3">-3</label><br>
                        <input value="-2" type="radio" id="x_-2" name="x"><label for="x_-2">-2</label><br>
                        <input value="-1" type="radio" id="x_-1" name="x"><label for="x_-1">-1</label><br>
                        <input value="0" type="radio" id="x_0" name="x"><label for="x_0">0</label><br>
                        <input value="1" type="radio" id="x_1" name="x"><label for="x_1">1</label><br>
                        <input value="2" type="radio" id="x_2" name="x"><label for="x_2">2</label><br>
                        <input value="3" type="radio" id="x_3" name="x"><label for="x_3">3</label><br>
                        <input value="" type="radio" id="X_value" name="x" hidden/>
                    </div>


                    <!-- Y value block -->
                    <div class="Y_value">
                        <label for="Y_value"> Y[-3; 5]: </label>
                        <input type="text" name="y" id="Y_value" style="margin-left: 5px" placeholder="Enter Y coordinate" maxlength="15"/>
                    </div>

                    <!-- R value block -->
                    <div class="R_value">

                        <label class="R_value"> R: </label><br>
                        <input value="1" type="checkbox" id="r_1" name="r"><label for="r_1">1</label><br>
                        <input value="2" type="checkbox" id="r_2" name="r"><label for="r_2">2</label><br>
                        <input value="3" type="checkbox" id="r_3" name="r"><label for="r_3">3</label><br>
                        <input value="4" type="checkbox" id="r_4" name="r"><label for="r_4">4</label><br>
                        <input value="5" type="checkbox" id="r_5" name="r"><label for="r_5">5</label><br>
                    </div>
                    <!-- Buttons reset and submit block -->
                    <div class="buttons">
                        <input id="form-submit" type ="submit" value="submit" id="submit">
                        <input type="reset" value="reset" id="reset">
                    </div>
                    <!-- Error text block -->
                    <div class="Error_text" style="margin: 5%; display:grid;">
                        <span id="x_error"></span>
                        <span id="y_error"></span>
                        <span id="r_error"></span>
                    </div>
                </div>


            </div>
        </form>
    </div>

    <!-- graphic -->
    <div style="margin-left: 6%;">
        <!-- Coordinates -->
        <svg width="300" height="300" style="background-color:white" id="graph">

            <line x1="0" x2="300" y1="150" y2="150"  stroke="black"></line>
            <line x1="150" x2="150" y1="0" y2="300" stroke="black"></line>

            <polygon points="150,0 145,15 155,15" stroke="black"></polygon>
            <polygon points="300,150 285,145 285,155" stroke="black"></polygon>

            <line x1="50" x2="50" y1="140" y2="160"></line>
            <line x1="100" x2="100" y1="140" y2="160"></line>
            <line x1="200" x2="200" y1="140" y2="160"></line>
            <line x1="250" x2="250" y1="140" y2="160"></line>

            <line x1="140" x2="160" y1="50" y2="50"></line>
            <line x1="140" x2="160" y1="100" y2="100"></line>
            <line x1="140" x2="160" y1="200" y2="200"></line>
            <line x1="140" x2="160" y1="250" y2="250"></line>
            <!-- Rectangle -->
            <polygon stroke="purple" fill="purple" fill-opacity="0.3" points="150,250 150,150 250,150 250,250"></polygon>
            <!-- Tringle -->
            <polygon stroke="purple" fill="purple" fill-opacity="0.3" points="150,100 150,150  200,150"></polygon>
            <!-- dots -->
            <circle cx="50" cy="150" r="1" stroke="black" stroke-width="3" />
            <circle cx="150" cy="50" r="1" stroke="black" stroke-width="3" />
            <circle cx="150" cy="100" r="1" stroke="black" stroke-width="3" />
            <circle cx="150" cy="150" r="1" stroke="black" stroke-width="3" />
            <circle cx="200" cy="150" r="1" stroke="black" stroke-width="3" />
            <circle cx="100" cy="150" r="1" stroke="black" stroke-width="3" />
            <circle cx="150" cy="200" r="1" stroke="black" stroke-width="3" />
            <circle cx="250" cy="150" r="1" stroke="black" stroke-width="3" />
            <circle cx="150" cy="250" r="1" stroke="black" stroke-width="3" />
            <!-- Circle -->
            <path stroke="purple" fill="purple" fill-opacity="0.3" d="M150,100 A50,50 90 0,0 100,150 L 150,150 Z"></path>

            <text x="285" y="135">X</text>
            <text x="160" y="15">Y</text>

            <text x="40" y="130">-R</text>
            <text x="85" y="130">-R/2</text>
            <text x="190" y="130">R/2</text>
            <text x="245" y="130">R</text>

            <text x="170" y="52.5">R</text>
            <text x="170" y="102.5">R/2</text>
            <text x="170" y="202.5">-R/2</text>
            <text x="170" y="252.5">-R</text>

            <g id="dots"></g>
        </svg>
    </div>
</div>
<!-- table blocks -->
<div style="display: grid; justify-items: center; align-content: flex-start;">
    <div>
        <div id="cleaner" class="cleaner">
            <a href="<%=request.getContextPath()%>/clean"><input type="button" value="Clean" id="clear_button"></a>
        </div>
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

            </tbody>
        </table>
    </div>
</div>
</body>

</html>