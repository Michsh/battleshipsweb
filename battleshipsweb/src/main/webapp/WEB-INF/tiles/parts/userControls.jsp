
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
    
    #userControls {
        
        text-align: center;
        background-color: white;
        border: 1px solid black;
        -moz-box-sizing: border-box;
        padding: 5px 5px 5px 5px;
    }
    
    .userButton {
        
        cursor: pointer;
        margin-left:auto;
        margin-right:auto;
        width: 70%;
        margin-bottom: 20px;
        height: 50px;
        background-color: #0099FF;
        border: 2px solid black;
        -moz-box-sizing: border-box;
        display: table;
    }
    
    .userButton p {
        
        display: table-cell; 
        vertical-align: middle; 
        text-align: center;
    }
    
</style>

<div id="userControls">
    
    <script src="userControls.js"></script>
    
    <p style="margin-bottom: 30px;">Hello, ${username}!</p>
    
    <div class="userButton">
        <p>Play</p>
    </div>
    
    <div class="userButton">
        <p>Stats</p>
    </div>
    
    <div class="userButton" id="logout">
        <p>Logout</p>
    </div>
    
</div>