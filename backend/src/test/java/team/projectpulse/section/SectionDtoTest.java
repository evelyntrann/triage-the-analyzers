package team.projectpulse.section;

import org.junit.jupiter.api.Test;
import team.projectpulse.section.dto.SectionDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SectionDtoTest {

    @Test
    void constructorShouldDefensivelyCopyActiveWeeks() {
        List<String> weeks = new ArrayList<>();
        weeks.add("Week 1");

        SectionDto dto = new SectionDto(
                1,                  // sectionId
                "Section A",        // sectionName
                "2026-01-01",       // startDate
                "2026-05-01",       // endDate
                1,                  // rubricId
                "Rubric A",         // rubricName
                weeks,              // activeWeeks
                1,                  // courseId
                true,               // isActive
                java.time.DayOfWeek.FRIDAY,
                "23:59",
                java.time.DayOfWeek.FRIDAY,
                "23:59"
        );

        weeks.add("Week 2");

        assertEquals(
                List.of("Week 1"),
                dto.activeWeeks(),
                "Modifying the original list must not change the DTO"
        );
    }
}
