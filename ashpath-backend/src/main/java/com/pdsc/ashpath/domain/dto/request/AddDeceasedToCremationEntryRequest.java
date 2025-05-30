package com.pdsc.ashpath.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddDeceasedToCremationEntryRequest
{
  private Long cremationEntryId;
  private Long deceasedId;
}
