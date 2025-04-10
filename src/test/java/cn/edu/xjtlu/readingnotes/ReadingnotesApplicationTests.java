package cn.edu.xjtlu.readingnotes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

//整合测试

@SpringBootTest
class ReadingnotesApplicationTests {

    @Test
    void contextLoads() {}
}

//单元测试
	
    @Test//类正常创建
    void testReadingLogCreation() {

        ReadingLog log = new ReadingLog("Test Title", "Test Author", LocalDate.now(), 30, "Test Note", 1L);

        assertNotNull(log, "ReadingLog 对象应该不为 null");

        assertEquals("Test Title", log.getTitle(), "标题应该正确设置");
        assertEquals("Test Author", log.getAuthor(), "作者应该正确设置");
        assertNotNull(log.getDate(), "日期应该不为 null");
        assertEquals(30, log.getSpentTime(), "花费时间应该正确设置");
        assertEquals("Test Note", log.getNote(), "笔记内容应该正确设置");
        assertEquals(1L, log.getUserId(), "用户 ID 应该正确设置");
    }

    @Test//方法正常使用
    void testReadingLogMethods() {

        ReadingLog log = new ReadingLog();

        log.setTitle("Test Title");
        log.setAuthor("Test Author");
        log.setDate(LocalDate.now());
        log.setSpentTime(30);
        log.setNote("Test Note");
        log.setUserId(1L);

        assertEquals("Test Title", log.getTitle(), "标题应该正确设置");
        assertEquals("Test Author", log.getAuthor(), "作者应该正确设置");
        assertNotNull(log.getDate(), "日期应该不为 null");
        assertEquals(30, log.getSpentTime(), "花费时间应该正确设置");
        assertEquals("Test Note", log.getNote(), "笔记内容应该正确设置");
        assertEquals(1L, log.getUserId(), "用户 ID 应该正确设置");

        log.setTitle("Updated Title");
        log.setAuthor("Updated Author");
        log.setDate(LocalDate.now().plusDays(1));
        log.setSpentTime(45);
        log.setNote("Updated Note");
        log.setUserId(2L);

        assertEquals("Updated Title", log.getTitle(), "标题应该更新为 'Updated Title'");
        assertEquals("Updated Author", log.getAuthor(), "作者应该更新为 'Updated Author'");
        assertNotNull(log.getDate(), "日期应该不为 null");
        assertEquals(45, log.getSpentTime(), "花费时间应该更新为 45");
        assertEquals("Updated Note", log.getNote(), "笔记内容应该更新为 'Updated Note'");
        assertEquals(2L, log.getUserId(), "用户 ID 应该更新为 2");
    }
}
