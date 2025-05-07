// Request notification permission
function requestNotificationPermission() {
    if ('Notification' in window) {
        Notification.requestPermission().then(function(permission) {
            if (permission === 'granted') {
                console.log('Notification permission granted');
            }
        });
    }
}

// Show notification for new message
function showMessageNotification(sender, message) {
    if (Notification.permission === 'granted' && document.hidden) {
        const notification = new Notification('New message from ' + sender, {
            body: message,
            icon: '/images/chat-icon.png'
        });
        
        notification.onclick = function() {
            window.focus();
            notification.close();
        };
    }
}