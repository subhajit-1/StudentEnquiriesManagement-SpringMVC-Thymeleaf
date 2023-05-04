package in.subhajit.service;

import java.util.List;
import java.util.Optional;

import in.subhajit.binding.DashboardResponse;
import in.subhajit.binding.EnquiryForm;
import in.subhajit.binding.EnquirySearchCriteria;
import in.subhajit.entity.StudentEnqEntity;

public interface EnquiryService {

	public DashboardResponse getDashboardData(Integer userId);

	public List<String> getCourses();

	public List<String> getEnqStatuses();

	public boolean saveEnquiry(EnquiryForm form);

	public List<StudentEnqEntity> getEnquiries();
	
	public List<StudentEnqEntity> getFilteredEnqs(EnquirySearchCriteria criteria, Integer userId);

	public Optional<StudentEnqEntity> findById(Integer userId);

}
