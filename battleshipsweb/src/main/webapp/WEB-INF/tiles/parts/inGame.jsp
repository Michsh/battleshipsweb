
<style>
    
    #inGame {
        
        background-color: white;
        border: 1px solid black;
        -moz-box-sizing: border-box;
        width: 100%;
        height: 100%;
        overflow: hidden;
    }
    
    #matchHeader {
        
        width: 100%;
        height: 10%;
        border-bottom: 1px solid black;
    }
    
    #headerLeft {
        
        float: left;
        
    }
    
    #headerRight {
        
        float: right;
        
    }
    
    #matchBody {
        
        width: 100%;
        height: 90%;
        background-color: yellow;
    }
    
    #leftBody {
        
        -moz-box-sizing: border-box;
        border-right: 1px solid black;
        float: left;
        width: 50%;
        height: 100%;
        background-color: white;
        padding: 30px 30px 30px 30px;
    }
    
    #rightBody {
        
        -moz-box-sizing: border-box;
        float: left;
        width: 50%;
        height: 100%;
        background-color: white;
        padding: 30px 30px 30px 30px;
    }
    
</style>

<div id="inGame">
    <script src="inGame.js"></script>
    
    <div id="matchHeader">
        
        <div id="headerLeft">
            
            You <img src="images/scout.png" style="width: 70px; height: 70px"/>
            
        </div>
        
        <div id="headerRight">
            
            Your enemy <img src="images/scout.png" style="width: 70px; height: 70px"/>
            
        </div>
        
    </div>
    
    <div id="matchBody">
        
        <div id="leftBody">
            
        </div>
        
        <div id="rightBody">
            
            
        </div>
        
    </div>
    
</div>


