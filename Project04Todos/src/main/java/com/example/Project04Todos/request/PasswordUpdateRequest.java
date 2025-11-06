package com.example.Project04Todos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PasswordUpdateRequest {

    @NotEmpty(message = "Password is mandatory")
    @Size(min=5, max=30, message = "Old password must be 5-30 characters long")
    private String oldPassword;

    @NotEmpty(message = "Password is mandatory")
    @Size(min=5, max=30, message = "New password must be 5-30 characters long")
    private String newPassword;

    @NotEmpty(message = "Password is mandatory")
    @Size(min=5, max=30, message = "Password confirmation must be 5-30 characters long")
    private String newPasswordConfirm;

    public PasswordUpdateRequest(String oldPassword, String newPassword, String newPasswordConfirm) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.newPasswordConfirm = newPasswordConfirm;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordConfirm() {
        return newPasswordConfirm;
    }

    public void setNewPasswordConfirm(String newPasswordConfirm) {
        this.newPasswordConfirm = newPasswordConfirm;
    }
}
