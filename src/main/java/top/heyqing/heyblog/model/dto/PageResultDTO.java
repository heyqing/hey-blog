package top.heyqing.heyblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName:PageResultDTO
 * Package:top.heyqing.heyblog.model.dto
 * Description:
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResultDTO<T> {

    private List<T> records;

    private Integer count;

}
