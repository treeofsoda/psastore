package com.psa.psastore.portal.repository;

import com.psa.psastore.portal.domain.MemberReadHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 会员商品浏览历史Repository
 * Created by macro on 2018/8/3.
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    Page<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId, Pageable pageable);
    void deleteAllByMemberId(Long memberId);
}
