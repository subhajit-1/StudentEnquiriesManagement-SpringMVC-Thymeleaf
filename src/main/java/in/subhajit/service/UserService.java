package in.subhajit.service;

import in.subhajit.binding.LoginForm;
import in.subhajit.binding.SignUpForm;
import in.subhajit.binding.UnlockForm;



public interface UserService {
	
	public String login(LoginForm form); 
	
	public boolean signup(SignUpForm form);
	
	public boolean unlockAccount(UnlockForm form);
	
	public boolean forgotPwd(String email);
	
	

}
