package manager;

import factory.PojoFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Complaint;
import pojo.Page;
import service.ComplaintManager;
import service.impl.ComplaintManagerImpl;

import java.util.Date;
import java.util.List;

/**
 * @author JohnGao
 * @date 8/2/2018 4:27 PM
 */
public class ComplaintManagerTest {
    private static ApplicationContext context;
    private ComplaintManager manager;
    @BeforeClass
    public static void init() {
        context=new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Before
    public void start() {
        manager = context.getBean(ComplaintManagerImpl.class);
    }

    @Test
    public void testAddComplaint(){
        Complaint comp = PojoFactory.getComplaintInstance();
        Complaint complaint = manager.addComplaint(comp);
        Assert.assertTrue(complaint.getId()!=null);
    }

    @Test
    public void testGetAllComplaint() throws Exception{
        Complaint comp = PojoFactory.getComplaintInstance();
        manager.addComplaint(comp);
        int num = manager.getAllComplaints().size();
        Assert.assertTrue(num>0);
    }
    @Test
    public void testDeleteComplaintById() throws Exception{
        int num = manager.getAllComplaints().size();
        Complaint comp = PojoFactory.getComplaintInstance();
        Complaint complaint = manager.addComplaint(comp);
        manager.deleteComplaint(complaint.getId());
        int num2 = manager.getAllComplaints().size();
        Assert.assertTrue(num == num2);
    }

    @Test
    public void testGetComplaintByPage(){
        Complaint comp = PojoFactory.getComplaintInstance();
        Complaint comp2 = PojoFactory.getComplaintInstance();
        manager.addComplaint(comp);
        manager.addComplaint(comp2);
        Page<Complaint> page = manager.getComplaintByPage(1,2);
        int m = page.getTotalPage();
        Assert.assertTrue(m>=1);
    }

    @Test
    public void testGetComplaintById() throws Exception{
        Complaint comp = PojoFactory.getComplaintInstance();
        Complaint complaint = manager.addComplaint(comp);
        List<Complaint> cps = manager.getComplaintById(complaint.getMerchantId());
        Assert.assertTrue(cps.size()>0&&cps.get(cps.size()-1).getId().equals(complaint.getId()));
    }
}