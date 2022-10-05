<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="index.css">
    <title>Generate QRCode</title>
</head>
<body align="center">
<%@ include file="header.jsp" %>
    <div>
        
        <form action="" method="post" name="regis">
            <input type="text" id="amount" placeholder="amount"  onblur="checkAmount(regis)" maxlength="5"> <br>
            <label for="amount" class="form__label"></label>
            <label class="alert-label" id="alertAmount">alertPrice</label><br><br>
        </form>
        

        <button onclick="genQR()" class="rainbow-button">Generate</button>
    </div>
    <img id="imgqr" src="" style="width: 500px; object-fit: contain;">

    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script>
        function genQR() {
            $.ajax({
                method: 'post',
                url: 'http://localhost:3000/generateQR',
                data: {
                    amount: parseFloat($("#amount").val())
                },
                success: function(response) {
                    console.log('good', response)
                    $("#imgqr").attr('src', response.Result)
                }, error: function(err) {
                    console.log('bad', err)
                }
            })
        }
    </script>
    
    <script>
    const express = require('express')
    const app = express();
    const QRCode = require('qrcode')
    const generatePayload = require('promptpay-qr')
    const bodyParser = require('body-parser')
    const _ = require('lodash')
    const cors = require('cors')

    app.use(cors())
    app.use(bodyParser.json())
    app.use(bodyParser.urlencoded( { extended: true }))

    const server = app.listen(3000, () => {
        console.log('server is running........')
    })

    app.post('/generateQR', (req, res) => {
        const amount = parseFloat(_.get(req, ["body", "amount"]));
        const mobileNumber = '0956879672';
        const payload = generatePayload(mobileNumber, { amount });
        const option = {
            color: {
                dark: '#000',
                light: '#fff'
            }
        }
        QRCode.toDataURL(payload, option, (err, url) => {
            if(err) {
                console.log('generate fail')
                return res.status(400).json({
                    RespCode: 400,
                    RespMessage: 'bad : ' + err
                })  
            } 
            else {
                return res.status(200).json({
                    RespCode: 200,
                    RespMessage: 'good',
                    Result: url
                })  
            }

        })
    })

    module.exports = app;


    // ราคา //
    function checkAmount(regis){
        var Amount = /^[0-9]{2,5}$/;
        var labelAlertamount = document.getElementById("alertAmount");
        if(regis.amount.value==("")){
          labelAlertamount.innerText="กรุณากรอกราคา";
          labelAlertamount.style.color="#ff5252";
          }
          else if(!regis.amount.value.match(Amount)){
            labelAlertamount.style.color="#ff5252";
            labelAlertamount.innerText="กรุณากรอกราคาเป็นตัวเลขเท่านั้น";
      
            regis.amount.value = "";
          }
          else{
            labelAlertamount.innerText="สามารถใช้ราคานี้ได้";
            labelAlertamount.style.color= "#4CAF50";
          }
        } 


    </script>
</body>
</html>