package org.infoscoop.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;

import org.infoscoop.acl.SecurityController;
import org.infoscoop.dao.TabTemplateDAO;
import org.infoscoop.dao.model.TabTemplate;
import org.infoscoop.util.SpringUtil;

public class TabTemplateService {
	
	private TabTemplateDAO dao;
	
	public void setTabTemplateDAO(TabTemplateDAO dao){
		this.dao = dao;
	}

	public static TabTemplateService getHandle() {
		return (TabTemplateService)SpringUtil.getBean("TabTemplateService");
	}

	public Map<String, String> getMyStaticAreaTemplate() {
		Map<String, String> templateMap = new HashMap<String, String>();
		Subject loginUser = SecurityController.getContextSubject();
		Collection<TabTemplate> templates = dao.all();
		for(TabTemplate template : templates){
			if(loginUser == null){
				//TODO:Check Role
			}else{
				//TODO:Check Role
			}
			templateMap.put(template.getTabId(), template.getLayout());
		}
		return templateMap;
	}
	
	public List<TabTemplate> getMyTabTemplate(){
		List<TabTemplate> templates = dao.all();
		Subject loginUser = SecurityController.getContextSubject();
		for(TabTemplate template : templates){
			if(loginUser == null){
				//TODO:Check Role
			}else{
				//TODO:Check Role
			}
		}
		return templates;
	}
}
