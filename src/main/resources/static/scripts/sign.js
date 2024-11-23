document.addEventListener('DOMContentLoaded', () => {
    const loginLink = document.getElementById('signup-link');
    const modal = document.getElementById('signup-modal');
    const modalContent = modal.querySelector('.modal-content');
    const closeBtn = document.getElementById('close-btn');
    const studentBtn = document.getElementById('student-btn');
    const companyBtn = document.getElementById('company-btn');

    const openModal = () => {
        modal.style.display = 'flex';
        modalContent.classList.remove('hidden');
        modalContent.style.animationName = 'fadeIn';
    };

    const closeModal = () => {
        modalContent.style.animationName = 'fadeOut';
        modalContent.addEventListener('animationend', () => {
            modal.style.display = 'none';
            modalContent.classList.add('hidden');
        }, { once: true });
    };

    loginLink.addEventListener('click', (event) => {
        event.preventDefault();
        openModal();
    });

    closeBtn.addEventListener('click', () => {
        closeModal();
    });

    window.addEventListener('click', (event) => {
        if (event.target === modal) {
            closeModal();
        }
    });

    studentBtn.addEventListener('click', () => {
    });

    companyBtn.addEventListener('click', () => {
    });
});
