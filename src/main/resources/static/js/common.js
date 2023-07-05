const editModal = document.getElementById('editUser')
if (editModal) {
    editModal.addEventListener('show.bs.modal', event => {
        // Button that triggered the modal
        const button = event.relatedTarget
        // Extract info from data-bs-* attributes
        const id = button.getAttribute('data-bs-id')
        const firstname = button.getAttribute('data-bs-firstname')
        const lastname = button.getAttribute('data-bs-lastname')
        const age = button.getAttribute('data-bs-age')
        const email = button.getAttribute('data-bs-email')
        // If necessary, you could initiate an Ajax request here
        // and then do the updating in a callback.

        // Update the modal's content.
        const modalidInput = editModal.querySelector('.modal-body input#id')
        const modalfirstnameInput = editModal.querySelector('.modal-body input#name')
        const modallastnameInput = editModal.querySelector('.modal-body input#lastName')
        const modalageInput = editModal.querySelector('.modal-body input#age')
        const modalemailInput = editModal.querySelector('.modal-body input#email')
        const form = editModal.querySelector('.modal-body form')

        form.action = "/admin/" + id

        modalidInput.value = id
        modalfirstnameInput.value = firstname
        modallastnameInput.value = lastname
        modalageInput.value = age
        modalemailInput.value = email
    })
}

const deleteModal = document.getElementById('deleteUser')
if (deleteModal) {
    deleteModal.addEventListener('show.bs.modal', event => {
        // Button that triggered the modal
        const button = event.relatedTarget
        // Extract info from data-bs-* attributes
        const id = button.getAttribute('data-bs-id')
        const firstname = button.getAttribute('data-bs-firstname')
        const lastname = button.getAttribute('data-bs-lastname')
        const age = button.getAttribute('data-bs-age')
        const email = button.getAttribute('data-bs-email')
        // If necessary, you could initiate an Ajax request here
        // and then do the updating in a callback.

        // Update the modal's content.
        const modalidInput = deleteModal.querySelector('.modal-body input#id')
        const modalfirstnameInput = deleteModal.querySelector('.modal-body input#name')
        const modallastnameInput = deleteModal.querySelector('.modal-body input#lastName')
        const modalageInput = deleteModal.querySelector('.modal-body input#age')
        const modalemailInput = deleteModal.querySelector('.modal-body input#email')
        const form = deleteModal.querySelector('.modal-body form')

        form.action = "/admin/" + id

        modalidInput.value = id
        modalfirstnameInput.value = firstname
        modallastnameInput.value = lastname
        modalageInput.value = age
        modalemailInput.value = email
    })
}

const URL = window.location.pathname
if (URL === "/admin/") {
    document.querySelector("a#admin").classList.add("active")
    document.querySelector("a#user").classList.remove("active")
} else {
    document.querySelector("a#user").classList.add("active")
    document.querySelector("a#admin").classList.remove("active")
}