const CSRF_TOKEN = document.querySelector('meta[name="_csrf"]')?.getAttribute("content");
const CSRF_HEADER = document.querySelector('meta[name="_csrf_header"]')?.getAttribute("content");

function initLogoutButton() {
    const logoutBtn = document.querySelector(".r_nav_logout_bt");
    if (logoutBtn) {
        logoutBtn.addEventListener("click", function (e) {
            e.preventDefault();
            fetch("/logout", { method: "GET", credentials: "include" })
                .then(() => window.location.href = "/login")
                .catch(err => alert("로그아웃 실패"));
        });
    }
}
