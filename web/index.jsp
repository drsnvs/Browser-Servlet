<%-- 
    Document   : index
    Created on : 10 Feb, 2024, 5:45:58 PM
    Author     : Darshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
        <style>
            .cal{
                background-color: blanchedalmond;
                border:5px solid black;
            }
            .set{
                margin: 10px;
                padding: 15px;
                width: 50%;
                /*border:2px solid black;*/
            }
            td{
                padding: 10px;
                /*width:50%;*/
            }
            input{
                width:400px;
            }
            button{
                color: white;
                background-color:brown;
                border:2px solid black;
            }
            h1{
                color: brown;
                border-bottom: 3px solid black;
                padding-bottom: 15px;
                font-weight:1000;
            }
        </style>
    </head>
    <body>
        <div class="cal" align="center">
            <form method="POST" action="Calculate" onsubmit="return validateform()">
                <h1>Calculator</h1>
                <table class="set">
                    <tr>
                        <td>Principal Amount (₹)</td>
                        <td><input type="number" id="pa" name="pa" placeholder="Enter principal amount"></td>
                    </tr>
                    <tr>
                        <td>Interest Rate</td>
                        <td><input type="number" step="0.01" id="ir" name="ir" placeholder="Enter interest rate"></td>
                    </tr>
                    <tr>
                        <td>Year</td>
                        <td><input type="number" id="year" name="year" max=100 placeholder="Enter year"></td>
                    </tr>
                    <tr>
                        <td>Month</td>
                        <td><input type="number" id="month" name="month" max=12 placeholder="Enter month"></td>
                    </tr>
                    <tr>
                        <td>Compound Interest</td>
                        <td>
                            <select name="ci">
                                <option value=365 id="ci">Daily(365/year)</option>
                                <option value=360 id="ci">Daily(360/year)</option>
                                <option value=52 id="ci">Weekly(52/year)</option>
                                <option value=26 id="ci">Bi-weekly(26/year)</option>
                                <option value=12 id="ci">Monthly(12/year)</option>
                                <option value=24 id="ci">Half-monthly(24/year)</option>
                                <option value=6 id="ci">Bi-monthly(6/year)</option>
                                <option value=4 id="ci">Quarterly(4/year)</option>
                                <option value=2 id="ci">Half-yearly(2/year)</option>
                                <option value=1 id="ci">yearly(1/year)</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><button type="submit">Calculate</button></td>
                    </tr>
                </table>
            </form>
        </div>
        <script type="text/javascript">  
            function validateform(){  
                var pa = document.getElementById("pa").value;
                var ir = document.getElementById("ir").value;
                var year = document.getElementById("year").value;
                var month = document.getElementById("month").value;
                var num_pattern = /^[0-9]{1,20}$/;
//                var date_pattern = /^\.\d{1,2}$/;
                if(!pa.match(num_pattern)){
                    alert("Fill up Principal amount");
                    return false;
                }
                if(ir==""){
                    alert("Enter Interest rate");
                    return false;
                }
                if(year == ""){
                    alert("Enter year");
                    return false;
                }
            }
        </script>
    </body>
</html>
