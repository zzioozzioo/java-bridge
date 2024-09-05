package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BridgeMakerTest {

    @DisplayName("다리 생성 테스트_D로만 구성된 경우")
    @Test
    void MakeBridgeTest_AlwaysZeroBridge() {
        //given
        int bridgeSize = 3;

        //when
        BridgeNumberGenerator alwaysZeroGenerator = () -> 0;
        BridgeMaker bridgeZeroMaker = new BridgeMaker(alwaysZeroGenerator);
        List<String> bridgeList = bridgeZeroMaker.makeBridge(bridgeSize);

        //then
        assertEquals(List.of("D", "D", "D"), bridgeList);
    }

    @DisplayName("다리 생성 테스트_U로만 구성된 경우")
    @Test
    void MakeBridgeTest_AlwaysOneBridge() {
        //given
        int bridgeSize = 3;

        //when
        BridgeNumberGenerator alwaysOneGenerator = () -> 1;
        BridgeMaker bridgeOneMaker = new BridgeMaker(alwaysOneGenerator);
        List<String> bridgeList = bridgeOneMaker.makeBridge(bridgeSize);

        //then
        assertEquals(List.of("U", "U", "U"), bridgeList);
    }

    @DisplayName("다리 생성 테스트_D와 U로 구성된 경우")
    @Test
    void MakeBridgeTest_ZeroAndOneBridge() {
        //given
        int bridgeSize = 3;

        //when
        BridgeNumberGenerator alternatingGenerator = new BridgeNumberGenerator() {
            int count = 0;

            @Override
            public int generate() {
                return count++ % 2;
            }
        };

        BridgeMaker bridgeZeroAndOneMaker = new BridgeMaker(alternatingGenerator);
        List<String> bridgeList = bridgeZeroAndOneMaker.makeBridge(bridgeSize);

        //then
        assertEquals(List.of("D", "U", "D"), bridgeList);
    }

    @DisplayName("다리 한 칸 생성 테스트_D가 저장된 경우")
    @Test
    void MakeOneKanTest_GenerateZero() {
        //given
        List<String> bridgeList = new ArrayList<>();

        //when
        BridgeNumberGenerator zeroGenerator = () -> 0;
        BridgeMaker bridgeMaker = new BridgeMaker(zeroGenerator);
        bridgeMaker.makeOneKan(bridgeList);

        //then
        assertEquals(List.of("D"), bridgeList);
    }

    @DisplayName("다리 한 칸 생성 테스트_U가 저장된 경우")
    @Test
    void MakeOneKanTest_GenerateOne() {
        //given
        List<String> bridgeList = new ArrayList<>();

        //when
        BridgeNumberGenerator oneGenerator = () -> 1;
        BridgeMaker bridgeMaker = new BridgeMaker(oneGenerator);
        bridgeMaker.makeOneKan(bridgeList);

        //then
        assertEquals(List.of("U"), bridgeList);
    }
}