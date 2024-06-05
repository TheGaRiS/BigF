package the.garis.bigf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the.garis.bigf.entity.TopicType;
import the.garis.bigf.repo.TopicTypeRepository;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicTypeRepository topicTypeRepository;

    @Override
    public String getTypes() {
        StringBuilder res = new StringBuilder();

        List<TopicType> types = topicTypeRepository.findAll();
        types.forEach(res::append);

        return res.toString();
    }
}
