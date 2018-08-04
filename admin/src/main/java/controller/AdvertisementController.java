package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Advertisement;
import pojo.Page;
import service.AdvertisementManager;

import java.util.List;

/**
 * @author JohnGao
 * @date 8/2/2018 9:06 AM
 */
@RestController
@RequestMapping(value = "advertisement")
public class AdvertisementController {
    @Autowired
    private AdvertisementManager manager;

    @RequestMapping(method = RequestMethod.PUT)
    public Advertisement updateAdvertisement(@RequestBody Advertisement advertisement){
        return manager.updateAdvertisement(advertisement);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Advertisement> getAdvertisementByPage(@RequestParam int currentPage, @RequestParam int pageSize){
        Page<Advertisement> page = manager.getAdsByPage(currentPage,pageSize);
        return page;
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
    public String deleteAd(@PathVariable String id){
        manager.deleteAdById(id);
        return "{}";
    }
}
