package EBus.EBusback.domain.stop.service;

import EBus.EBusback.domain.member.entity.Member;
import EBus.EBusback.domain.stop.dto.StopPinReqDto;
import EBus.EBusback.domain.stop.entity.BusStop;
import EBus.EBusback.domain.stop.entity.PinStop;
import EBus.EBusback.domain.stop.repository.BusStopRepository;
import EBus.EBusback.domain.stop.repository.PinStopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StopService {
    private final PinStopRepository pinStopRepository;
    private final BusStopRepository busStopRepository;

    // 정류장 핀 등록/취소
    public List<Integer> createOrRemovePin(Member member, StopPinReqDto stopPinReqDto) {
        if (member == null)
            throw new RuntimeException("사용자를 찾을 수 없습니다.");

        List<Integer> stopId = new ArrayList<>();

        for (int i=0; i<8; i++){
            BusStop stop = busStopRepository.findByStopId(i+1);
            PinStop pinStop = pinStopRepository.findByMemberAndStop(member, stop)
                    .orElseGet(() -> pinStopRepository.save(PinStop.builder().member(member).stop(stop).build()));
            pinStop.updatePinStop(stopPinReqDto.getStopPinned().get(i));

            if(pinStop.getIsValid()){
                stopId.add(i+1);
            }
        }
        return stopId;
    }
}