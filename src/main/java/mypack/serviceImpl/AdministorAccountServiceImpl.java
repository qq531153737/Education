package mypack.serviceImpl;

import mypack.dao.AdministorMapper;
import mypack.pojo.Administor;
import mypack.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdministorAccountServiceImpl")
public class AdministorAccountServiceImpl implements AccountService {

    @Autowired
    private AdministorMapper administorMapper;

    @Override
    public boolean login(long id, String password) {

        if(administorMapper.findWithIdAndPassword((int)id, password) == null) {
            return false;
        }
        return true;
    }

}
