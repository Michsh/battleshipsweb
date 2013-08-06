
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    
    #rankingPart {
        
        padding: 5px 5px 5px 5px;
        background-color: white;
        border: 1px solid black;
        -moz-box-sizing: border-box;
        
    }
    
    #rankingList {
        
        padding: 0px;
        list-style-position: inside
    }
    
    #rankingList li:nth-child(even) {
        
        background-color: #FF4D4D;
    }
    
    #rankingList li:nth-child(odd) {
        
        background-color: #33D6FF;
    }
    
</style>

<div id="rankingPart">
    
    <h1 style="margin-top: 0px">Ranking of all players</h1>
    
    <ol id="rankingList" type="I">
        <c:forEach items="${ranking}" var="user">
            
            <li style="margin-left: 0px;"><span style="font-weight: bold">${user.username}</span>: ${user.score}</li>
            
        </c:forEach>
    </ol>
    
</div>