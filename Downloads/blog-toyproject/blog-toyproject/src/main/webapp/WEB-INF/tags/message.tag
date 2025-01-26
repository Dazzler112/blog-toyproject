<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
#alert-container {
    position: fixed;
    top: 10%;
    left: 50%;
    transform: translateX(-50%);
    z-index: 1000;
    width: 300px;
    padding: 15px;
    border-radius: 5px;
    font-family: Arial, sans-serif;
    text-align: center;
    display: none;
    border: 1px solid #ccc;
}

.alert-body {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.alert-body span {
    margin-bottom: 10px;
}

.close-alert {
    background: none;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
    font-size: 14px;
}
</style>

<!-- Alert 컨테이너 -->
<div id="alert-container" style="display: none;">
    <div class="alert-body">
        <span id="alert-message"></span>
        <button type="button" class="close-alert" onclick="closeAlert()">닫기</button>
    </div>
</div>

<script>
// Alert 표시 함수
function showAlert(message, type) {
    const alertContainer = document.getElementById('alert-container');
    const alertMessage = document.getElementById('alert-message');

    alertMessage.textContent = message;
    alertContainer.style.display = 'block';
    alertContainer.style.backgroundColor = type === 'success' ? '#d4edda' : '#f8d7da';
}

// Alert 닫기 함수
function closeAlert() {
    const alertContainer = document.getElementById('alert-container');
    alertContainer.style.display = 'none';
}
</script>