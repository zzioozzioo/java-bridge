package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BridgePrinterTest {

    @DisplayName("한 칸 이동한 결과 추가 테스트")
    @Test
    void AddStepBridgeTest() {
        //given
        BridgePrinter bridgePrinter = new BridgePrinter();
        String upStep = "O";
        String downStep = " ";

        //when
        bridgePrinter.addStepBridge(upStep, downStep);

        //then
        assertEquals("[ O ]", bridgePrinter.upStringJoiner.toString());
        assertEquals("[   ]", bridgePrinter.downStringJoiner.toString());

    }

    @DisplayName("현재까지 이동한 결과 추가 테스트")
    @Test
    void AddAllBridgeTest() {
        //given
        BridgePrinter bridgePrinter = new BridgePrinter();
        List<String> upStatus = List.of("O", " ", "X");
        List<String> downStatus = List.of(" ", "O", " ");

        //when
        bridgePrinter.addAllBridge(upStatus, downStatus);

        //then
        assertEquals("[ O |   | X ]", bridgePrinter.upStringJoiner.toString());
        assertEquals("[   | O |   ]", bridgePrinter.downStringJoiner.toString());
    }

    @DisplayName("현재까지 이동한 결과 출력 테스트")
    @Test
    void BridgePrintTest() {
        //given
        BridgePrinter bridgePrinter = new BridgePrinter();
        List<String> upStatus = List.of("O", " ", "X");
        List<String> downStatus = List.of(" ", "O", " ");

        bridgePrinter.addAllBridge(upStatus, downStatus);

        //when
        String result = bridgePrinter.print();

        //then
        assertEquals(("[ O |   | X ]" + "\n" + "[   | O |   ]" + "\n"), result);
    }
}
