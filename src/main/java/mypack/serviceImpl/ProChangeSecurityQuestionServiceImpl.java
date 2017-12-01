package mypack.serviceImpl;

import mypack.dao.ProfessorMapper;
import mypack.pojo.Professor;
import mypack.pojo.Securitypro;
import mypack.pojo.Securitystu;
import mypack.service.ChangeSecurityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProChangeSecurityQuestionServiceImpl")
public class ProChangeSecurityQuestionServiceImpl implements ChangeSecurityQuestionService {
    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public boolean checkAnswer(Long id, String question1, String answer1, String question2, String answer2, String question3, String answer3) {
        return false;
    }

    @Override
    public void resetSecurityQuestion(Long id, String question1, String answer1, String question2, String answer2, String question3, String answer3) {
        System.out.println("开始设置密保");
        professorMapper.resetSecurityQuestion(id,question1,question2,question3,answer1,answer2,answer3);
        System.out.println("ending");
    }

    @Override
    public Securitypro securityQuestionQuery2(Long id) {
        Securitypro securitypro=professorMapper.securityQuestionQuery(id);
        return securitypro;
    }

    @Override
    public Securitystu securityQuestionQuery(Long id) {
        return null;
    }
}
