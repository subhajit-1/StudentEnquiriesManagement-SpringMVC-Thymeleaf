package in.subhajit.service.impl;



import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.subhajit.binding.LoginForm;
import in.subhajit.binding.SignUpForm;
import in.subhajit.binding.UnlockForm;
import in.subhajit.constants.AppConstants;
import in.subhajit.entity.UserDtlsEntity;
import in.subhajit.repo.UserDtlsRepo;
import in.subhajit.service.UserService;
import in.subhajit.util.EmailUtils;
import in.subhajit.util.PwdUtils;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserDtlsRepo userDtlsRepo; 
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private HttpSession session;
	
	
	@Override
	public String login(LoginForm form) {
		UserDtlsEntity entity = userDtlsRepo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		if(entity == null) {
			return "Invalid Credentials";
		}
		if(entity.getAccStatus().equals(AppConstants.STR_LOCKED)) {
			return AppConstants.ACC_LOCKED;
		}
		
		//create session and store user data in session
		session.setAttribute("userId", entity.getUserId());
		
		return "success";
	}
	
	
	@Override
	public boolean unlockAccount(UnlockForm form) {
    UserDtlsEntity entity = userDtlsRepo.findByEmail(form.getEmail());
		if(entity.getPwd().equals(form.getTempPwd())) {
			entity.setPwd(form.getNewPwd());
			entity.setAccStatus(AppConstants.STR_UNLOCKED);
			userDtlsRepo.save(entity);
			return true;
		}else {
		   return false;	
		}
	}
	
	
	@Override
	public boolean signup(SignUpForm form) {
		
		UserDtlsEntity user = userDtlsRepo.findByEmail(form.getEmail());
		
		if(user != null) {
			return false;
		}
		
		//TODO: Copy data from binding obj to entity obj
		UserDtlsEntity entity = new UserDtlsEntity();
		BeanUtils.copyProperties(form, entity);
		
		// TODO:generate random pwd and set to object
		String tempPwd = PwdUtils.generateRandomPwd();
		entity.setPwd(tempPwd);
		
		// TODO:Set account status as LOCKED
		entity.setAccStatus(AppConstants.STR_LOCKED);
		
		// TODO:Insert record
		userDtlsRepo.save(entity);
		
		// TODO:Send email account
		String to = form.getEmail();
		String subject = "Unlock Your Account | Ashok IT";
		//String body = "<h1>Use below temporary pwd to unlock your account</h1>"; 
		StringBuffer body=new StringBuffer();
		body.append("<h1>Use below temporary pwd to unlock your account</h1>");
		body.append("Temporary pwd : " + tempPwd);
		body.append("<br/>");
		body.append("<a href=\"http://localhost:9091/unlock?email="+to+"\")>Click Here To Unlock Your Account</a>");
		emailUtils.sendEmail(to, subject, body.toString());
		return true;
	}


	@Override
	public boolean forgotPwd(String email) {
		// check record presence in db with given email
		UserDtlsEntity entity = userDtlsRepo.findByEmail(email);
		
		//if record not available return false
		if(entity == null) {
			return false;
		}
		
		//if record available send pwd to email and return true
		String subject = "Recover Password";
		String body = "Your Pwd :: "+ entity.getPwd();
		emailUtils.sendEmail(email, subject, body);
		return true;
	}



  }
