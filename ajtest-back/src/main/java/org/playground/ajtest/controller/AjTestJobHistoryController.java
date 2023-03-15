package org.playground.ajtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.diboot.core.vo.*;
import com.diboot.iam.annotation.OperationCons;
import com.diboot.iam.annotation.BindPermission;
import com.diboot.iam.annotation.Log;
import org.playground.ajtest.entity.AjTestJobHistory;
import org.playground.ajtest.dto.AjTestJobHistoryDTO;
import org.playground.ajtest.vo.AjTestJobHistoryListVO;
import org.playground.ajtest.vo.AjTestJobHistoryDetailVO;
import org.playground.ajtest.service.AjTestJobHistoryService;
import org.playground.ajtest.controller.BaseCustomCrudRestController;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import java.util.List;

/**
 * 执行历史 相关Controller
 *
 * @author anjie
 * @version 1.0
 * @date 2023-03-09
 * Copyright © anjieCR
 */
@RestController
@RequestMapping("/ajTestJobHistory")
@BindPermission(name = "执行历史")
@Slf4j
public class AjTestJobHistoryController extends BaseCustomCrudRestController<AjTestJobHistory> {

    @Autowired
    private AjTestJobHistoryService ajTestJobHistoryService;

    /**
     * 查询ViewObject的分页数据
     * <p>
     * url请求参数示例: /list?field=abc&pageIndex=1&orderBy=abc:DESC
     * </p>
     *
     * @return
     * @throws Exception
     */
    @Log(operation = OperationCons.LABEL_LIST)
    @BindPermission(name = OperationCons.LABEL_LIST, code = OperationCons.CODE_READ)
    @GetMapping("/list")
    public JsonResult getViewObjectListMapping(AjTestJobHistoryDTO queryDto, Pagination pagination) throws Exception {
        return super.getViewObjectList(queryDto, pagination, AjTestJobHistoryListVO.class);
    }

    /**
     * 根据资源id查询ViewObject
     *
     * @param id ID
     * @return
     * @throws Exception
     */
    @Log(operation = OperationCons.LABEL_DETAIL)
    @BindPermission(name = OperationCons.LABEL_DETAIL, code = OperationCons.CODE_READ)
    @GetMapping("/{id}")
    public JsonResult getViewObjectMapping(@PathVariable("id") Long id) throws Exception {
        return super.getViewObject(id, AjTestJobHistoryDetailVO.class);
    }

    /**
     * 创建资源对象
     *
     * @param entity
     * @return JsonResult
     * @throws Exception
     */
    @Log(operation = OperationCons.LABEL_CREATE)
    @BindPermission(name = OperationCons.LABEL_CREATE, code = OperationCons.CODE_WRITE)
    @PostMapping("/")
    public JsonResult createEntityMapping(@Valid @RequestBody AjTestJobHistory entity) throws Exception {
        return super.createEntity(entity);
    }

    /**
     * 根据ID更新资源对象
     *
     * @param entity
     * @return JsonResult
     * @throws Exception
     */
    @Log(operation = OperationCons.LABEL_UPDATE)
    @BindPermission(name = OperationCons.LABEL_UPDATE, code = OperationCons.CODE_WRITE)
    @PutMapping("/{id}")
    public JsonResult updateEntityMapping(@PathVariable("id") Long id, @Valid @RequestBody AjTestJobHistory entity) throws Exception {
        return super.updateEntity(id, entity);
    }

    /**
     * 根据id删除资源对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Log(operation = OperationCons.LABEL_DELETE)
    @BindPermission(name = OperationCons.LABEL_DELETE, code = OperationCons.CODE_WRITE)
    @DeleteMapping("/{id}")
    public JsonResult deleteEntityMapping(@PathVariable("id") Long id) throws Exception {
        return super.deleteEntity(id);
    }
}
