package ltd.newbee.mall.controller;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 新增一条记录
    @GetMapping("/insert")
    public String insert(String type, String name) {
        if (StringUtils.isEmpty(type) || StringUtils.isEmpty(name)) {
            return "参数异常";
        }
        jdbcTemplate.execute("INSERT INTO `jdbc_test` (`ds_name`, `ds_type`) VALUES (\"" + name + "\",\"" + type + "\")");
//        jdbcTemplate.execute("insert into jdbc_test('ds_name', 'ds_type') value (\"" + type + "\",\"" + name + "\")");
        return "sql执行完毕";
    }

    @GetMapping("/delete")
    public String delete(int id) {
        if (id < 0) {
            return "参数异常";
        }
        List<Map<String, Object>>result = jdbcTemplate.queryForList("select * from jdbc_test where ds_id = \"" + id + "\"");
        if (CollectionUtils.isEmpty(result)) {
            return "不存在该记录,删除失败";
        }
        jdbcTemplate.execute("delete from jdbc_test where ds_id=\"" + id + "\"");
        return "SQL执行完毕";
      }

      @GetMapping("/update")
      public String update(int id, String type, String name) {
        if (id < 0 || StringUtils.isEmpty(type) || StringUtils.isEmpty(name)) {
            return "参数异常";
        }
        List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from jdbc_test where ds_id = \"" + id + "\"");
        if(CollectionUtils.isEmpty(result)) {
            return "不存在该记录，无法修改";
        }
        jdbcTemplate.execute("update jdbc_test set ds_type= \"" + type + "\", ds_name = \"" + name + "\" where ds_id = \"" + id + "\"");
        return "Sql执行完毕";
      }

      @GetMapping("/queryAll")
      public List<Map<String, Object>> queryAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from jdbc_test");
        return list;
      }

}
