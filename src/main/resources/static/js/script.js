document.addEventListener('DOMContentLoaded', function() {
    const darkModeToggle = document.getElementById('darkModeToggle');
    const body = document.body;

    let darkMode = localStorage.getItem('darkMode');
    if (darkMode === 'enabled') {
        body.classList.add('dark-mode');
    }
    if (darkModeToggle) {
        darkModeToggle.addEventListener('click', () => {
            darkMode = localStorage.getItem('darkmode');
            if (darkMode !== 'enabled') {
                body.classList.add('dark-mode');
                localStorage.setItem('darkmode', 'enabled');
            } else {
                body.classList.remove('dark-mode');
                localStorage.setItem('darkmode', null);
            }
        });
    }
});