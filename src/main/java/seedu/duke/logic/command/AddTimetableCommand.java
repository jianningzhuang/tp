package seedu.duke.logic.command;

import seedu.duke.Lesson;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddTimetableCommand extends Command {
    private final String moduleCode;
    private final String day;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String venue;
    private final String lessonType;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
    private static final Logger logger = Logger.getLogger("AddTimetableCommand");

    public AddTimetableCommand(String moduleCode, String lessonType, String venue,
                               String day, String startTime, String endTime) {
        logger.log(Level.INFO, "start initialising AddTimeTableCommand");
        this.moduleCode = moduleCode;
        this.day = day;
        this.startTime = LocalTime.parse(startTime, formatter);
        this.endTime = LocalTime.parse(endTime, formatter);
        this.venue = venue;
        this.lessonType = lessonType;
        logger.log(Level.INFO, "AddTimeTableCommand initialised");
    }

    @Override
    public void execute(Data data, Ui ui) {
        assert startTime != null : "startTime must be initialised";
        Lesson lesson = new Lesson(day, startTime, endTime, venue, lessonType);
        data.find(moduleCode).addLesson(lesson);
        ui.printNewTimetable(moduleCode, lesson);
    }
}
